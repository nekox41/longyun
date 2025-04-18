import request from '@/utils/request'

// 查询文章图片列表
export function listImage(query) {
  return request({
    url: '/server/image/list',
    method: 'get',
    params: query
  })
}

// 查询文章图片详细
export function getImage(imageId) {
  return request({
    url: '/server/image/' + imageId,
    method: 'get'
  })
}

// 新增文章图片
export function addImage(data) {
  return request({
    url: '/server/image',
    method: 'post',
    data: data
  })
}

// 修改文章图片
export function updateImage(data) {
  return request({
    url: '/server/image',
    method: 'put',
    data: data
  })
}

// 删除文章图片
export function delImage(imageId) {
  return request({
    url: '/server/image/' + imageId,
    method: 'delete'
  })
}
