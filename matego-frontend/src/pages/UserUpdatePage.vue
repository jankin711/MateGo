<template>
  <template v-if="user">
    <van-cell
      title="昵称"
      is-link
      to="/user/edit"
      :value="user.username"
      @click="toEdit('username', '昵称', user.username)"
    />
    <van-cell title="账户" :value="user.userAccount" />
    <van-cell
      title="头像"
      is-link
      to="/user/edit"
      :value="user.avatarUrl"
      @click="toEdit('avatarUrl', '头像', user.avatarUrl)"
    >
      <img style="height: 48px" :src="user.avatarUrl" />
    </van-cell>
    <van-cell title="性别" :value="user.gender">
      <template #value>
        <div v-if="user.gender === 0">男</div>
        <div v-if="user.gender === 1">女</div>
      </template>
    </van-cell>
    <van-cell
      title="电话"
      is-link
      to="/user/edit"
      :value="user.phone"
      @click="toEdit('phone', '电话', user.phone)"
    />
    <van-cell
      title="邮箱"
      is-link
      to="/user/edit"
      :value="user.email"
      @click="toEdit('email', '邮箱', user.email)"
    />
    <van-cell title="注册时间" :value="user.createTime" />
  </template>
</template>
  
<script setup lang="ts">
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { getCurrentUser } from "../services/user";

const user = ref();

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

onMounted(async () => {
  user.value = await getCurrentUser();
});
</script>
  
<style scoped>
</style>