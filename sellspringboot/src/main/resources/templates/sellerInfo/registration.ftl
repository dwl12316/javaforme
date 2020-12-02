<html lang="zh">
<#include "../common/header.ftl">
<body>
<div class="container col-md-offset-4 col-lg-offset-4col-xl-offset-4" style="padding-top: 250px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="color: #64468f;border-width:1px;">
            <form class="form-horizontal" role="form"  action="/seller/user/save" method="post">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">用户账号</label>
                    <div class="col-sm-10">
                        <input name="openid" type="text"  id="inputEmail3"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input name="username" type="text"  id="inputEmail3"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input name="onepassword" type="password"  id="inputEmail3"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-10">
                        <input name="secpassword" type="password"  id="inputPassword3"/>
                    </div>
                </div>
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>