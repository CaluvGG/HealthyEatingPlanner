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
function togglePassword(child) {
    const contain = child.parentNode;
    const password = contain.querySelector('.pass_key');
    const showButton = contain.querySelector('.show img');
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
    var n = 1;
    var msg = document.getElementById('erro_msg');
    if (msg) {
        msg.style.display = 'block'; // Hiển thị thông báo

        setTimeout(function () {
            msg.style.transition = 'opacity 0.5s ease';
            msg.style.opacity = '0'; // Lm cho msg mờđi trong 0,5 giây
            setTimeout(function () {
                msg.style.display = 'none'; // Tắt display sau 0.5 giây
            }, 500);
        }, n * 1000); // Sau n*1000 milliseconds = n giây thì cái trên chạy


    }
});

// Change page for cards
function showPage(pageNumber) {
    const pages = document.querySelectorAll('.card-page');
    pages.forEach(page => {
        page.classList.remove('active');
    });
    document.getElementById('page' + pageNumber).classList.add('active');
}

document.addEventListener('DOMContentLoaded', function () {
    const menuContainer = document.querySelector('.menu-container');
    const scrollButtons = document.querySelectorAll('.scroll-btn');

    // Scroll by a set amount (adjust this value as needed)
    const scrollAmount = menuContainer.clientWidth / 2;

    // Scroll on mouse wheel
    menuContainer.addEventListener('wheel', (event) => {
        event.preventDefault();
        menuContainer.scrollLeft += event.deltaY;
    });

    // Scroll on button click
    scrollButtons.forEach(button => {
        button.addEventListener('click', () => {
            if (button.classList.contains('left')) {
                menuContainer.scrollLeft -= scrollAmount;
            } else {
                menuContainer.scrollLeft += scrollAmount;
            }
        });
    });
});