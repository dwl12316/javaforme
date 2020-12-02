<html xmlns="http://www.w3.org/1999/html" lang="zh">
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--    边栏nav-->
    <#include "../common/nav.ftl">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <h3>
                        商品类目列表页
                    </h3>
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>
                                类目编号
                            </th>
                            <th>
                                类目名字
                            </th>
                            <th>
                                类目编号
                            </th>
                            <th>
                                创建时间
                            </th>
                            <th>
                                更新时间
                            </th>
                            <th colspan="2">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list categorylist as category>
                            <tr>
                                <td>
                                    ${category.categoryId}
                                </td>
                                <td>
                                    ${category.categoryName}
                                </td>
                                <td>
                                    ${category.categoryType}
                                </td>
                                <td>
                                    ${category.createTime}
                                </td>
                                <td>
                                    ${category.updateTime}
                                </td>
                                <td>
                                    <a href="/seller/category/index?categoryId=${category.categoryId}">
                                        <button class="btn btn-default">
                                            修改
                                        </button>
                                    </a>
                                </td>
                                <td>
<#--                                    <a href="/seller/category/delete?categoryId=${category.categoryId}" onclick="sendBtn(this);return false;">删除</a>-->
                                    <form action="/seller/category/delete?categoryId=${category.categoryId}" method="post">
                                        <button type="submit" class="btn btn-default">
                                            删除
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<#--<script>-->
<#--    function sendBtn(node) {-->
<#--        var url = node.href;/*得到href的值*/-->
<#--        $.ajax({-->
<#--            url:url,-->
<#--            type:'DELETE',-->
<#--            success:function (result) {-->
<#--                //判断result结果-->
<#--                if(result){-->
<#--                    window.location.reload();-->
<#--                }else{-->
<#--                    alert("返回了false")-->
<#--                }-->
<#--            }-->
<#--        })-->
<#--    };-->
<#--</script>-->

</body>
</html>
