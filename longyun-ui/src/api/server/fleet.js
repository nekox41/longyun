import request from '@/utils/request'

// 查询车队管理列表
export function listFleet(query) {
  return request({
    url: '/server/fleet/list',
    method: 'get',
    params: query
  })
}

// 查询车队管理详细
export function getFleet(id) {
  return request({
    url: '/server/fleet/' + id,
    method: 'get'
  })
}

// 新增车队管理
export function addFleet(data) {
  return request({
    url: '/server/fleet',
    method: 'post',
    data: data
  })
}

// 修改车队管理
export function updateFleet(data) {
  return request({
    url: '/server/fleet',
    method: 'put',
    data: data
  })
}

// 删除车队管理
export function delFleet(id) {
  return request({
    url: '/server/fleet/' + id,
    method: 'delete'
  })
}
