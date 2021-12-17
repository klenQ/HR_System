<template>
  <el-container>
    <el-header style="height:120px">
      <div id="top">
        <div id="logo">人事管理系统</div>
      </div>
    </el-header>
    <el-container>
      <el-aside width="200px">
          <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose">

            <el-menu-item>
              <i class="el-icon-s-home"></i>
              <span slot="title">欢迎界面</span>
            </el-menu-item>
            <el-menu-item>
              <i class="el-icon-s-custom"></i>
              <router-link to="/emp/show">员工管理</router-link>
            </el-menu-item>
            <el-menu-item>
              <i class="el-icon-s-management"></i>
              <span slot="title">部门管理</span>
            </el-menu-item>
            <el-submenu>
              <template slot="title"><i class="el-icon-setting"></i>权限管理</template>
              <el-menu-item-group>
                <el-menu-item>用户管理</el-menu-item>
                <el-menu-item>角色管理</el-menu-item>
                <el-menu-item>权限管理</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
      </el-aside>
      <el-main>
        <router-view/>
      </el-main>
    </el-container>
    <el-footer style="height:120px">Footer</el-footer>
  </el-container>
</template>

<script>
export default {
  name: "Index",
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>
<style scoped>
.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  height: 400px;
}

.el-main {
  background-color: #fff;
  color: #333;
  text-align: center;
}

#top {
  clear: both;
  height: 80px;
  text-align: left;
}

#top #logo {
  color: #fff;
  font-size: 30px;
  font-weight: bold;
  padding: 15px 0 0 40px;
}
</style>
