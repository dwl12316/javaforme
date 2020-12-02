<html lang="zh">
<#include "../common/header.ftl">
<body>
<div class="container col-md-offset-4 col-lg-offset-4col-xl-offset-4" style="padding-top: 250px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="color: #64468f;border-width:1px; border-color: #64468f">
            <form class="form-horizontal" role="form" ; action="/seller/user/login" method="post">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">用户账号</label>
                    <div class="col-sm-10">
                        <input id="inputEmail3" name="openid" type="text"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input id="inputPassword3" name="onepassword" type="password"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label><input type="checkbox"/>Remember me</label>
                        </div>
                    </div>
                </div>
                <span class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">登录</button>

                    <a href="/seller/user/regist">
                    <button class="btn btn-default" type="button">
                        注册
                    </button>
                    </a>
                </span>
            </form>
        </div>
    </div>
</div>
</body>
</html>