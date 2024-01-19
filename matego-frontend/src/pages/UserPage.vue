<template>
  <van-cell title="昵称" is-link to="/user/edit" :value="user.username" />
  <van-cell title="账号" is-link to="/user/edit" :value="user.userAccount" />
  <van-cell title="头像" is-link to="/user/edit">
    <img style="height: 48px" :src="user.avatarUrl" />
  </van-cell>
  <van-cell
    title="性别"
    is-link
    to="/user/edit"
    :value="user.gender"
    @click="toEdit('gender', '性别', user.gender)"
  />
  <van-cell
    title="电话"
    is-link
    to="/user/edit"
    :value="user.phone"
    @click="toEdit('phone', '电话', user.phone)"
  />
  <van-cell title="邮箱" is-link to="/user/edit" :value="user.email" />
  <van-cell title="注册时间" :value="user.createTime.toISOString()" />
</template>

<script setup lang="ts">
import { useRouter } from "vue-router";

const user = {
  id: 1,
  username: "罗围",
  userAccount: "0679",
  avatarUrl:
    "https://img1.baidu.com/it/u=2428624434,1821504445&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500",
  gender: "女",
  phone: "13012410679",
  email: "781524813@qq.com",
  createTime: new Date(),
};

const router = useRouter();

const toEdit = (editKey: string, editName: string, currentValue: string) => {
  router.push({
    path: "/user/edit",
    query: {
      editKey,
      editName,
      currentValue,
    },
  });
};
</script>

<style scoped>
</style>