<template>
  <el-table
      :data="tableData"
      style="width: 100%"
      max-height="100%"
      width="auto"
      align="center">
    <el-table-column
        fixed
        prop="id"
        label="水果编号"
        width="160">
    </el-table-column>
    <el-table-column
        prop="name"
        label="水果名称"
        width="160">
    </el-table-column>
    <el-table-column
        prop="sale"
        label="水果销量"
        width="160">
    </el-table-column>
    <el-table-column
        prop="icon"
        label="水果图片"
        width="160"
        >
      <template slot-scope="scope">
        <img :src="scope.row.icon" style="height: 70px">
      </template>
    </el-table-column>
    <el-table-column
        fixed="right"
        label="操作"
        width="160"
        style="float: left">
      <template slot-scope="scope">
        <el-button
            @click.native.prevent="deleteFruit(scope.row)"
            type="text"
            size="small">
          删除
        </el-button>
        <el-button
            @click.native.prevent="findFruit(scope.row)"
            type="text"
            size="small">
          编辑
        </el-button>
        <el-button
            @click.native.prevent="addFruit(scope.row)"
            type="text"
            size="small">
          添加
        </el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  methods: {
    addFruit(object){
      this.$router.push('add');
    },
    findFruit(object){
      this.$router.push('/edit?id='+object.id)//页面跳转
    },
    //删除水果
    deleteFruit(object) {
      // alert(row.id);
      let _this = this
      this.$confirm('是否确定要删除'+object.name + "?", '删除数据',{
        confirmButtonText:"确定",
        cancelButtonText:"取消",
        type:'warning'
      }).then(()=>{
        axios.delete("http://localhost:8181/fruit/delete/"+object.id).then(function(response){
          if(response.data){//返回值为真，删除成功
            _this.$alert(object.name+'删除成功!', '删除数据',{
              confirmButtonText: '确定',
              callback: action => {
                //刷新页面
                location.reload();
              }
            })
          }
        })
      })
    }
  },
    created(){
      let _this = this;//保留vue对象
      axios.get("http://localhost:8181/fruit/list").then(function(response){
        // console.log(response)
        _this.tableData = response.data;
      })
    },
  data() {
    return {
      tableData: []
    }
  }
}
</script>
