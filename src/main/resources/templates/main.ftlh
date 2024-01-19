<#import "parts/common.ftlh" as c>

<@c.page>

    <div class="row g-3">
        <div class="col-md-6">
            <form method="get" action="/main" class = "form-inline">
                <#include "parts/functionSelector.ftlh">
                <button type="submit" class="btn btn-primary m-2">Find</button>
            </form>
        </div>
    </div>


</@c.page>