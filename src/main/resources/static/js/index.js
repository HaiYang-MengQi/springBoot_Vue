document.addEventListener('DOMContentLoaded',
    function () {
    var loginForm = document.getElementById('loginForm');
    loginForm.addEventListener('submit', function (e) {
        e.preventDefault();
        sendMessage()
    }
    )
})
function sendMessage() {
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var data = JSON.stringify({
        username: username,
        password: password
    })
    var xhr =  new XMLHttpRequest();
    xhr.open('POST', '/user/login', true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(data);
    xhr.onreadystatechange = function () {
        if(xhr.readyState == 4 && xhr.status == 200){
            var data = JSON.parse(xhr.responseText)
            console.log(data)
            sessionStorage.setItem('token', data.data);
        }
    }
}