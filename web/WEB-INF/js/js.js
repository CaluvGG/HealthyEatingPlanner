//Dropdown for icon
document.addEventListener("DOMContentLoaded", function () {
    const opts = document.querySelector('.opts');

    const isLoggedIn = true;
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

