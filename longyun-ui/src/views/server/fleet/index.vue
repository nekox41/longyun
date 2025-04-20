<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="车队名称" prop="fleetName">
        <el-input v-model="queryParams.fleetName" placeholder="请输入车队名称" clearable @keyup.enter="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['server:fleet:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate"
          v-hasPermi="['server:fleet:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['server:fleet:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="Download" @click="handleExport"
          v-hasPermi="['server:fleet:export']">导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="fleetList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" type="index" align="center" prop="id" />
      <el-table-column label="车队名称" align="center" prop="fleetName" />
      <el-table-column label="车队图片" align="center" prop="images" width="100">
        <template #default="scope">
          <image-preview :src="scope.row.images" :width="50" :height="50" />
        </template>
      </el-table-column>
      <el-table-column label="联系方式" align="center" prop="contact" />
      <el-table-column label="车队介绍" align="center" prop="description">
        <template #default="scope">
          <div v-html="scope.row.description"></div>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['server:fleet:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
            v-hasPermi="['server:fleet:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改车队管理对话框 -->
    <el-dialog :title="title" v-model="open" width="800px" append-to-body>
      <el-form ref="fleetRef" :model="form" :rules="rules" label-width="80px">
        <el-row gutter="24">
          <el-col :span="12">
            <el-form-item label="车队名称" prop="fleetName">
              <el-input v-model="form.fleetName" placeholder="请输入车队名称" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="联系方式" prop="contact">
              <el-input v-model="form.contact" placeholder="请输入联系方式" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="车队图片" prop="images">
          <image-upload v-model="form.images" />
        </el-form-item>

        <el-form-item label="车队介绍">
          <editor v-model="form.description" :min-height="192" />
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

<script setup name="Fleet">
import { listFleet, getFleet, delFleet, addFleet, updateFleet } from "@/api/server/fleet";

const { proxy } = getCurrentInstance();

const fleetList = ref([]);
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
    fleetName: null,
  },
  rules: {
    fleetName: [
      { required: true, message: "车队名称不能为空", trigger: "blur" }
    ],
    contact: [
      { required: true, message: "联系方式不能为空", trigger: "blur" }
    ],
    description: [
      { required: true, message: "车队介绍不能为空", trigger: "blur" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询车队管理列表 */
function getList() {
  loading.value = true;
  listFleet(queryParams.value).then(response => {
    fleetList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    id: null,
    fleetName: null,
    images: null,
    contact: null,
    description: null
  };
  proxy.resetForm("fleetRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加车队管理";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value
  getFleet(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改车队管理";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["fleetRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateFleet(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addFleet(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除车队管理编号为"' + _ids + '"的数据项？').then(function () {
    return delFleet(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => { });
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('server/fleet/export', {
    ...queryParams.value
  }, `fleet_${new Date().getTime()}.xlsx`)
}

getList();
</script>
