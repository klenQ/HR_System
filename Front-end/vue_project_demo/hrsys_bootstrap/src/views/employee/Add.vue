<template>
    <div id="container">
        <form class="form-horizontal" @submit.prevent="add">
            <div class="form-group">
                <label class="col-sm-2 control-label">编号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="请输入编号" v-model="form.number">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">名字</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="请输入名字"
                           v-model="form.name">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">性别</label>
                <div class="col-sm-10">
                    <input type="radio" value="男" v-model="form.gender"/>男<input type="radio"
                                                                                 value="女" v-model="form.gender"/>女
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">年龄</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="请输入年龄"
                           v-model="form.age">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">部门</label>
                <div class="col-sm-10">
                    <select class="form-control" v-model="form.dep.id">
                        <option v-for="dep in depList"
                                v-text="dep.name" v-bind:key="dep.id" v-bind:value="dep.id">
                        </option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">保存</button>
                </div>
            </div>
        </form>
    </div>
</template>

<script>
    export default {
        name: "Add",
        data() {
            return {
                form: {
                    number: null,
                    name: null,
                    gender: null,
                    age: null,
                    dep: {
                        id: null
                    }
                },
                depList: []
            }
        },
        methods: {
            add: function () {
                this.axios.post('/emp', this.form)
                    .then(function (res) {
                        if (res.data == true) {
                            this.$router.push({name: "EmpShow"})
                        } else {
                            alert("系统错误");
                        }
                    }.bind(this))
            },
            searchDep: function () {
                this.axios.get('/dep')
                    .then(function (res) {
                        this.depList = res.data;
                        this.form.dep.id = this.depList[0].id
                    }.bind(this))
            },

        },
        created() {
            this.searchDep();
        }
    }
</script>

<style scoped>
    #container {
        width: 600px;
        margin: 10px auto;
    }
</style>