<html lang="zh">
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form"  method="post" action="/seller/category/save">
                        <div class="form-group">
                            <label for="exampleInputEmail1">类目名称</label>
                            <input name="categoryName" type="text" class="form-control" value="${(category.categoryName)!''}">
                        </div>

                        <div class="form-group">
                            <label for="exampleInputEmail1">类目类别</label>
                            <input name="categoryType" type="text" class="form-control" value="${(category.categoryType)!''}">
                        </div>

                        <input hidden type="text" name="categoryId" value="${(category.categoryId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>