<html lang="zh">
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--    边栏nav-->
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#--                        通过.content 获取page中的每一个对象-->
                        <#list productInfoPage.content as productInfo>
                            <tr>
                                <td>${productInfo.productId}</td>
                                <td>${productInfo.productName}</td>
                                <td>
                                    <img height="100" , width="100" src="${productInfo.productIcon}" alt="">
                                </td>
                                <td>${productInfo.productPrice}</td>
                                <td>${productInfo.productStock}</td>
                                <td>${productInfo.productDescription}</td>
                                <td>${productInfo.categoryType}</td>
                                <td>${productInfo.createTime}</td>
                                <td>${productInfo.updateTime}</td>
                                <td>
                                    <a href="/seller/product/index?productId=${productInfo.productId}">
                                        <button class="btn btn-default">修改</button>
                                    </a>
                                </td>
                                <td>
                                    <#--                                    <a href="/seller/product/put?productId=${productInfo.productId}" onclick="sendBtn(this);return false;">-->
                                    <#--                                        <#if productInfo.productStatus==0>-->
                                    <#--                                            下架-->
                                    <#--                                        <#else>-->
                                    <#--                                            上架-->
                                    <#--                                        </#if>-->

                                    <#--                                    </a>-->
                                    <form action="/seller/product/put?productId=${productInfo.productId}" method="post">
                                        <button type="submit" class="btn btn-default">
                                            <#if productInfo.productStatus==0>
                                                下架
                                            <#else>
                                                上架
                                            </#if>
                                        </button>
                                    </form>
                                </td>

                            </tr>
                        </#list>

                        </tbody>
                    </table>
                </div>
                <div class="col-md-12 column">
                    <#--                    pull-right 控件靠右-->
                    <ul class="pagination pull-right">

                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else >
                            <li><a href="/seller/product/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                        </#if>

                        <#--               1.. val 代表从1 开始循环       获取查询数据的总页数  ${productInfoPage.getTotalPages()  }-->

                        <#list 1..productInfoPage.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else >
                                <li><a href="/seller/product/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>

                        </#list>


                        <#if currentPage gte productInfoPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/seller/product/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                        </#if>
                    </ul>
                </div>

            </div>
        </div>
    </div>

</div>
<#--<script>-->
<#--    function sendBtn(node) {-->
<#--        var url = node.href;/*得到href的值*/-->
<#--        $.ajax({-->
<#--            url: url,-->
<#--            type: 'PUT',-->
<#--            success: function (result) {-->
<#--                //判断result结果-->
<#--                if (result) {-->
<#--                    window.location.reload();-->
<#--                } else {-->
<#--                    alert("返回了false")-->
<#--                }-->
<#--            }-->
<#--        })-->
<#--    };-->
<#--</script>-->
</body>
</html>