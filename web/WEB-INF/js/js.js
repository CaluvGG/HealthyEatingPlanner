//Dropdown for icon
document.addEventListener("DOMContentLoaded", function () {
    const opts = document.querySelector('.opts');

    const isLoggedIn = false;
    /* check if user is logged in, e.g. using a token or session */;
    
    
    // Gọi Ajax để kiểm tra đăng nhập
//    fetch('/IsLoggin_Filter', { //Gọi đến đường dẫn của filter
//        method: 'GET', //phương thức lấy thông tin
//    })
//
//        .then(response => response.text()) // chuyển dạng stream sang dạng văn bản
//        .then(isLoggedIn => {
            if (isLoggedIn) {
                // Show logged_in user options
                document.querySelectorAll('.logged-in-only').forEach((element) => {
                    element.style.display = 'block';
                });
                document.querySelectorAll('.logged-out-only').forEach((element) => {
                    element.style.display = 'none';
                });
            } else {
                // Show not_log_in user options
                document.querySelectorAll('.logged-in-only').forEach((element) => {
                    element.style.display = 'none';
                });
                document.querySelectorAll('.logged-out-only').forEach((element) => {
                    element.style.display = 'block';
                });
            }

            opts.addEventListener('mouseenter', function () {
                opts.classList.add('active');
            });

            opts.addEventListener('mouseleave', function () {
                opts.classList.remove('active');
            });
//        });


});

//Toggle pass

function togglePassword() {
    const password = document.querySelector('.pass_key');
    const showButton = document.querySelector('.show img');
    if (password.type === 'password') {
        password.type = 'text';
        showButton.src = 'icons/crossed-eye.png';
    } else {
        password.type = 'password';
        showButton.src = 'icons/eye.png';
    }
}
// Kiểm tra sự khớp nhau của mật khẩu và mật khẩu xác nhận
//Confirm pass
document.addEventListener("DOMContentLoaded", function () {
    // Lấy các phần tử DOM cần thiết
    var passwordForm = document.getElementById("Reg_form");
    var passwordInput = document.getElementById("password");
    var confirmPasswordInput = document.getElementById("confirmPassword");
    var passwordError = document.getElementById("passwordError");

    // Hàm kiểm tra và hiển thị thông báo lỗi
    function validatePassword(event) {
        event.preventDefault(); // Ngăn chặn việc submit mặc định của form

        var password = passwordInput.value.trim();
        var confirmPassword = confirmPasswordInput.value.trim();
        
        if (password !== "" && confirmPassword !== "") {
            if (password !== confirmPassword) {
                // Nếu mật khẩu và xác nhận mật khẩu không khớp
                passwordError.textContent = 'Passwords do not match';
                passwordError.style.display = 'block';
            } else {
                // Nếu mật khẩu và xác nhận mật khẩu khớp nhau, ẩn thông báo lỗi
                passwordError.style.display = 'none';
            }
        } else {
            // Nếu mật khẩu và xác nhận mật khẩu khớp nhau, ẩn thông báo lỗi
            passwordError.style.display = 'none';
        }
    }

    // Thêm sự kiện 'input' cho các trường nhập mật khẩu
    passwordInput.addEventListener('input', validatePassword);
    confirmPasswordInput.addEventListener('input', validatePassword);
});

