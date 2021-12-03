<#macro registrationLayout bodyClass="" displayInfo=false displayMessage=true displayRequiredFields=false displayWide=false showAnotherWayIfPresent=true>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class="${properties.kcHtmlClass!}">

<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="robots" content="noindex, nofollow">

    <#if properties.meta?has_content>
        <#list properties.meta?split(' ') as meta>
            <meta name="${meta?split('==')[0]}" content="${meta?split('==')[1]}"/>
        </#list>
    </#if>
    <title>${msg("loginTitle",(realm.displayName!''))}</title>
    <link rel="icon" href="${url.resourcesPath}/img/favicon.ico" />
    <#if properties.styles?has_content>
        <#list properties.styles?split(' ') as style>
            <link href="${url.resourcesPath}/${style}" rel="stylesheet" />
        </#list>
    </#if>
    <#if properties.scripts?has_content>
        <#list properties.scripts?split(' ') as script>
            <script src="${url.resourcesPath}/${script}" type="text/javascript"></script>
        </#list>
    </#if>
    <#if scripts??>
        <#list scripts as script>
            <script src="${script}" type="text/javascript"></script>
        </#list>
    </#if>
</head>


  <body>
    <div class="flex flex-col gap-5 items-center bg-no-repeat xl:bg-cover bg-contain w-full h-[100vh]" style="background-image: url(${url.resourcesPath}/img/head.png); ">
		<img class="w-48 absolute mt-4" src="${url.resourcesPath}/img/ram.png" alt="">
		<div class="bg-white my-auto w-full h-full sm:h-auto sm:w-[400px] rounded-md shadow-lg flex flex-col justify-center items-center p-8 gap-8">
			<h1 class="text-[#C20831] text-4xl">Se Connecter</h1>
			<h3 class="text-gray-300">Welcome to TAT management software, please enter your credentials, to be able to use the app.</h3>
          	<#if displayMessage && message?has_content && (message.type != 'warning' || !isAppInitiatedAction??)>
				<#if message.type = 'success'><span class="font-bold text-green-500">${kcSanitize(message.summary)?no_esc}</span></#if>
				<#if message.type = 'warning'><span class="font-bold text-yellow-500">${kcSanitize(message.summary)?no_esc}</span></#if>
				<#if message.type = 'error'><span class="font-bold text-red-500">${kcSanitize(message.summary)?no_esc}</span></#if>
				<#if message.type = 'info'><span class="font-bold text-blue-500">${kcSanitize(message.summary)?no_esc}</span></#if>
          	</#if>
			<form id="kc-form-login" onsubmit="login.disabled = true; return true;" action="${url.loginAction}" method="post" class="w-full gap-4 flex flex-wrap justify-center items-center">
				<input tabindex="1" id="username" name="username" value="${(login.username!'')}" autofocus required class="w-full h-10 border-b border-gray-300 pl-1" type="text" placeholder="${msg('usernameOrEmail')}">
				<input tabindex="2" id="password" name="password" type="password" required class="w-full h-10 border-b border-gray-300 pl-1" type="text" placeholder="${msg('password')}">
				<input 				id="id-hidden-input" name="credentialId" type="hidden" <#if auth.selectedCredential?has_content>value="${auth.selectedCredential}"</#if>/>
				<button tabindex="3" class="bg-[#C20831] text-white rounded-full w-14 h-14 flex justify-center items-center shadow-md mt-10" name="login" id="kc-login" type="submit" value="${msg('doLogIn')}">
					<img class="w-6 h-6" src="${url.resourcesPath}/img/iconlogin.png">
				</button>
			</form>
		</div>
	</div>
  </body>
</html>
</#macro>
