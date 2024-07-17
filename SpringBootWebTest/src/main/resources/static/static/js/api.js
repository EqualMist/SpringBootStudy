function askVerifyCode() {
    get('/static/api/auth/verify-code', {
        email: $('#input-email').val()
    }, function (data) {
        alert(data.msg);
    })
}

function login() {
    post('/static/api/auth/login', {
        username: $('#username').val(),
        password: $('#password').val()
    }, function (data) {
        if (data.code === 200) {
            window.location = '/static/index.html';
        } else {
            alert(data.msg);
        }
    })
}

function logout() {
    post('/static/api/auth/logout', function (data) {
        if (data.code === 200) {
            window.location = '/static/login.html';
        } else {
            alert(data.msg);
        }
    })
}

function initUserInfo() {
    get('/static/api/user/getUserInfo', function (data) {
        if (data.code === 200) {
           $('#profile-name').val(data.data.username);
        } else {
            window.location = '/static/login.html';
        }
    })
}


function get(url, data,success){
    $.ajax({
        type: "get",
        url: url,
        data: data,
        async: true,
        dataType: 'json',
        xhrFields: {
            withCredentials: true
        },
        success: success
    });
}

function post(url, data, success){
    $.ajax({
        type: "post",
        url: url,
        async: true,
        data: data,
        dataType: 'json',
        xhrFields: {
            withCredentials: true
        },
        success: success
    });
}