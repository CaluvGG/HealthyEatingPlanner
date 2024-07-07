//Dropdown for icon
document.addEventListener("DOMContentLoaded", function () {
    const opts = document.querySelector('.opts');

    opts.addEventListener('mouseenter', function () {
        opts.classList.add('active');
    });

    opts.addEventListener('mouseleave', function () {
        opts.classList.remove('active');
    });



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

//Display message for n_s
document.addEventListener('DOMContentLoaded', function () {
    var n = 2;
    var msg = document.getElementById('erro_msg');
    if (msg) {
        msg.style.display = 'block'; // Hiển thị thông báo

        setTimeout(function () {
            msg.style.display = 'none'; // Ẩn thông báo sau 1 giây
            msg.style.transition = 'opacity 0.3s ease';
        }, n*1000); // n*1000 milliseconds = n giây
        
        
    }
});
