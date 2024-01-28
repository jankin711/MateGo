<template>
  <user-card-list :user-list="userList" :loading="loading" />
  <van-empty
    v-if="!userList || userList.length < 1"
    
    description="搜索结果为空"
  />
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import { Toast } from "vant";
import myAxios from "../plugins/myAxios";
import qs from "qs";
import UserCardList from "../components/UserCardList.vue";

const route = useRoute();
const { tags } = route.query;
const loading = ref(true);

const userList = ref([]); //存放用户列表

onMounted(async () => {
  loading.value = true;
  // 为给定 ID 的 user 创建请求
  const userListData = await myAxios
    .get("/user/search/tags", {
      // withCredentials: false,
      params: {
        tagNameList: tags,
      },
      //序列化
      paramsSerializer: {
        serialize: (params) => qs.stringify(params, { indices: false }),
      },
    })
    .then(function (response) {
      console.log("/user/search/tags succeed", response);
      Toast.success("请求成功");
      return response?.data; //返回数据  ?.可选链操作符，避免数据为null或undefined时报错
    })
    .catch(function (error) {
      console.log("/user/search/tags error", error);
      Toast.fail("请求失败");
    });
  if (userListData) {
    userListData.forEach((user) => {
      if (user.tags) {
        user.tags = JSON.parse(user.tags);
      }
    });
    userList.value = userListData;
  }
  loading.value = false;
});
</script>

<style scoped>
</style>