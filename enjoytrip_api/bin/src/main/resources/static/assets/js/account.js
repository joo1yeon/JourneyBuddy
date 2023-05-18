// 이메일 도메인 정보
var emailDomainArr = [
    "",
    "@gmail.com",
    "@naver.com",
    "@kakao.com",
    "@ssafy.com",
];

// contextPath
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	return contextPath;
}

// 로그인 수행
function login() {
    let loginModal = document.getElementById("loginModal");

    let id = loginModal.querySelector("[name='userId']").value;
    let password = loginModal.querySelector("[name='userPassword']").value;
    let checkBox = loginModal.querySelector("#id-checkbox");

	let loginForm = document.querySelector("#login-form");
	loginForm.submit(); 
	

    // TODO 계정 정보 추후 DB에서 받아오는 기능 구현 필요
    let available = accountInfo.find((e) => {
        if (e.id === id && e.password === password) return true;
        else return false;
    });
    
    fetch(`/user/login`)
    	.then((response) => response.json())
    	.then((data) => makeList(data));
}

// 회원가입 입력 창 초기화
function reset() {
    let registerModal = document.getElementById("registerModal");
    let inputs = registerModal.getElementsByTagName("input");

    // 모든 입력 초기화
    for (element of inputs) {
        element.value = "";
    }

    let emailDomain = registerModal.getElementsByTagName("select");
    for (element of emailDomain) {
        element.value = 0;
    }
}

// 회원가입
function register() {
    let registerModal = document.getElementById("registerModal");

    // 계정 정보 입력
    let account = {};
    account.name = registerModal.querySelector("[name='name']").value;
    if (!account.name) {
        alert("이름을 입력해주세요!");
        return;
    }

    account.id = registerModal.querySelector("[name='id']").value;
    if (!account.id) {
        alert("아이디를 입력해주세요!");
        return;
    }

    account.password = registerModal.querySelector("[name='password']").value;
    if (!account.password) {
        alert("비밀번호를 입력해주세요!");
        return;
    }

    let passwordConfirm = registerModal.querySelector(
        "[name='password-confirm']"
    ).value;
    if (account.password !== passwordConfirm) {
        alert("비밀번호가 다릅니다.");
        return;
    }

    account.email = registerModal.querySelector("[id='register-email']").value;
    if (!account.email) {
        alert("이메일을 입력해주세요!");
        return;
    }

    /*
	 * let emailDomain = emailDomainArr[
	 * registerModal.querySelector("[id='emali-domain']").value ]; if
	 * (!emailDomain) { alert("이메일도메인을 선택해주세요!"); return; } account.email +=
	 * emailDomain;
	 */
    
    let joinForm = document.querySelector("#join-form");
	joinForm.setAttribute("action", getContextPath() + "/user?action=join");
	joinForm.submit();

	/*
	 * // 모든 정보가 채워져 있다면 회원가입 alert("회원가입이 완료되었습니다!");
	 *  // 정보 저장 accountInfo.push(account); localStorage.setItem("accountInfo",
	 * JSON.stringify(accountInfo)); location.reload();
	 */
}

// 아이디 찾기
function findId() {
    let email = prompt("가입 시 입력한 이메일을 입력해주세요.");

    let account = accountInfo.find((obj) => obj.email === email);
    if (account) {
        alert(`해당 이메일을 가진 계정의 아이디는 '${account.id}'입니다.`);
    } else {
        alert("해당 이메일을 가진 계정은 존재하지 않습니다.");
    }
}

// 비밀번호 찾기
function findPassword() {
    let id = prompt("가입 시 입력한 아이디를 입력해주세요.");
    let email = prompt("가입 시 입력한 이메일을 입력해주세요.");

    let account = accountInfo.find(
        (obj) => obj.email === email && obj.id === id
    );

    if (account) {
        let password = prompt("새로 변경할 비밀번호를 입력해주세요.");
        account.password = password;
        // 정보 저장
        localStorage.setItem("accountInfo", JSON.stringify(accountInfo));
        alert(`비밀번호가 변경되었습니다!`);
        location.reload();
    } else {
        alert("해당 계정 정보를 가진 계정은 존재하지 않습니다.");
    }
}

// 회원 정보 수정
function updateInfo() {
    let account = accountInfo.find((e) => {
        if (e.id === loginInfo.loginId) return true;
        else return false;
    });

    if (account) {
        let userInfo = document.getElementById("user-info");
        let password = userInfo.querySelector("[id='password']").value;
        if (!password) {
            alert("수정할 비밀번호를 입력해주세요!");
            return;
        }

        account.password = password;
        // 정보 저장
        localStorage.setItem("accountInfo", JSON.stringify(accountInfo));
        alert("회원 정보가 변경되었습니다!");
        location.reload();
    } else {
        alert("해당 계정 정보를 가진 계정은 존재하지 않습니다.");
    }
}

// 회원 탈퇴
function withdraw() {
    if (confirm("정말 탈퇴하시겠습니까?")) {
        accountInfo = accountInfo.filter((e) => e.id !== loginInfo.loginId);
        // 계정 정보 반영
        localStorage.setItem("accountInfo", JSON.stringify(accountInfo));
        loginInfo.isLogin = false;
        loginInfo.loginId = "";
        sessionStorage.setItem("loginInfo", JSON.stringify(loginInfo));
        window.open("/views/index.html", "_self");
    }
}
