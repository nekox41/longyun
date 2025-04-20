<template>

  <div class="app-container">

    <div class="editContainer"><el-button type="success" @click="handleUpdate">修改公司信息</el-button></div>

    <el-descriptions title="公司信息" border :column="2">
      <el-descriptions-item label="公司名称">
        <div>{{ form.companyName }}</div>
      </el-descriptions-item>
      <el-descriptions-item label="联系方式">
        <div>{{ form.companyContact }}</div>
      </el-descriptions-item>
    </el-descriptions>

    <el-collapse class="descriptionCollapse">
      <el-collapse-item title="公司介绍">
        <div v-html="form.companyDescription"></div>
      </el-collapse-item>
    </el-collapse>

    <!-- 添加或修改公司信息对话框 -->
    <el-dialog :title="title" v-model="open" width="800px" append-to-body>
      <el-form ref="companyRef" :model="form" :rules="rules" label-width="80px">
        <el-row gutter="24">
          <el-col :span="12">
            <el-form-item label="公司名称" prop="companyName">
              <el-input v-model="form.companyName" placeholder="请输入公司名称" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="联系方式" prop="companyContact">
              <el-input v-model="form.companyContact" placeholder="请输入联系方式" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="车队介绍" prop="companyDescription">
          <editor v-model="form.companyDescription" :min-height="192" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Company">
import { getInfo, getCompany, delCompany, addCompany, updateCompany } from "@/api/server/company";

const { proxy } = getCurrentInstance();

const companyList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
  },
  rules: {
    companyName: [
      {required: true, message: "公司名称不能为空", trigger: "blur"}
    ],
    companyContact: [
      {required: true, message: "联系方式不能为空", trigger: "blur"}
    ],
    companyDescription: [
      {required: true, message: "公司描述不能为空", trigger: "blur"}
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询公司信息 */
function info() {
  loading.value = true;
  getInfo().then(response => {
    form.value = response.data;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}


/** 修改按钮操作 */
function handleUpdate() {
  const _id = 1;
  getCompany(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改公司信息";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["companyRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateCompany(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addCompany(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

info();
</script>

<style>
.editContainer {
  margin-bottom: 50px;
  margin-top: 15px;
}

.descriptionCollapse {
  margin-top: 50px;
}
</style>