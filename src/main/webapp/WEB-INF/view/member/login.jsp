<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="/WEB-INF/common/header.jsp" %>

<style>
    .KAKAO {
        background-image: url(${pageContext.request.contextPath}/resources/images/login/kakao_login_large_wide.png);
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        /* background-color: #FEE500; */
    }

    .lni-kakao {
        color: #000000;
    }
</style>

<!-- Start Breadcrumbs -->
<div class="breadcrumbs overlay">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6 col-md-6 col-12">
                <div class="breadcrumbs-content">
                    <h1 class="page-title">로그인</h1>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-12">
                <ul class="breadcrumb-nav">
                    <li><a href="/">Home</a></li>
                    <li>로그인</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- End Breadcrumbs -->

<!-- start login section -->
<section class="login section">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 offset-lg-3 col-md-8 offset-md-2 col-12">
                <div class="form-head" style="padding: 0px;">
                    <div id="infoArea">
                        <nav>
                            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                <button class="nav-link active show1"
                                        style="width: 50%; font-size: 1.5em; transition: none;" data-bs-toggle="tab"
                                        data-bs-target="#nav-grid" type="button" role="tab" aria-controls="nav-grid"
                                        aria-selected="true">고객 가입
                                </button>
                                <button class="nav-link show2" id="nav-list-tab" data-bs-toggle="tab"
                                        data-bs-target="#nav-list" type="button" role="tab"
                                        style="width: 50%; font-size: 1.5em; transition: none;" aria-controls="nav-list"
                                        aria-selected="false">사업자 가입
                                </button>
                            </div>
                        </nav>
                    </div>
                    <div>
                        <div class="d1">
                            <form method="post"
                                  style="border: 1px solid #c9c9c9; border-top: none; padding: 40px;">
                                <div class="form-group mt-4">
                                    <label>아이디</label>
                                    <input name="email" type="email">
                                </div>
                                <div class="form-group">
                                    <label>비밀번호</label>
                                    <input name="password" type="password">
                                </div>
                                <div class="check-and-pass">
                                    <div class="row align-items-center">
                                        <div class="col-lg-6 col-md-6 col-12">
                                            <div class="form-check">
                                                <input type="checkbox" class="form-check-input width-auto"
                                                       id="exampleCheck1">
                                                <label class="form-check-label">로그인 저장</label>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-12">
                                            <a href="javascript:void(0)" class="lost-pass">비밀번호를 잊어버리셨나요?</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="button">
                                    <input type="hidden" name="addr" class="addr">
                                    <button type="submit" class="btn mt-3">로그인</button>
                                </div>
                                <div class="alt-option">
                                    <span>Or</span>
                                </div>
                                <div class="socila-login">
                                    <ul>
                                        <li><a href="javascript:void(0)" class="KAKAO" img><i
                                                class="lni lni-kakao">카카오로 시작하기</i></a></li>
                                    </ul>
                                </div>
                                <p class="outer-link">
                                    <a href="/member/register">회원가입</a>
                                </p>
                            </form>
                        </div>
                        <div class="d2">
                            <form method="post"
                                  style="border: 1px solid #c9c9c9; border-top: none; padding: 40px;">
                                <div class="form-group mt-4">
                                    <label>아이디</label>
                                    <input name="email" type="email">
                                </div>
                                <div class="form-group">
                                    <label>비밀번호</label>
                                    <input name="password" type="password">
                                </div>
                                <div class="check-and-pass">
                                    <div class="row align-items-center">
                                        <div class="col-lg-6 col-md-6 col-12">
                                            <div class="form-check">
                                                <input type="checkbox" class="form-check-input width-auto"
                                                       id="exampleCheck1">
                                                <label class="form-check-label">로그인 저장</label>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-12">
                                            <a href="javascript:void(0)" class="lost-pass">비밀번호를 잊어버리셨나요?</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="button">
                                    <button type="submit" class="btn mt-3">로그인</button>
                                </div>
                                <div class="alt-option">
                                    <span>Or</span>
                                </div>
                                <div class="socila-login">
                                    <ul>
                                        <li><a href="javascript:void(0)" class="KAKAO" img><i
                                                class="lni lni-kakao">카카오로 시작하기</i></a></li>
                                    </ul>
                                </div>
                                <p class="outer-link">
                                    <a href="/member/register">회원가입</a>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end login section -->

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(document).ready(function () {
        $('.addr').val(location.search.substring(1)).attr("disabled", false);
    })

    $(document).ready(function () {
        $('.d1').show(); //페이지를 로드할 때 표시할 요소
        $('.d2').hide(); //페이지를 로드할 때 숨길 요소
        $('.di').css({background: '#c9c9c9'});
        $('.show1').css({
            color: '#00000',
            // backgroundColor:'#f3f9ff',
            border: '2px solid #c9c9c9',
            borderBottom: 'none'
        });
        $('.show2').css({borderBottom: '1px solid #c9c9c9'});
        $('.show2').click(function () {
            $('.d1').hide(); //클릭 시 첫 번째 요소 숨김
            $('.d2').show(); //클릭 시 두 번째 요소 표시
            $('.show2').css({
                color: '#00000',
                // backgroundColor:'#f3f9ff',
                border: '2px solid #c9c9c9',
                borderBottom: 'none'
            });
            $('.show1').css({
                color: '#00000',
                backgroundColor: 'white',
                border: 'none',
                borderBottom: '1px solid #c9c9c9'
            });
            return false;
        });
    });
    $('.show1').click(function () {
        $('.d2').hide(); //클릭 시 첫 번째 요소 숨김
        $('.d1').show(); //클릭 시 두 번째 요소 표시
        $('.show1').css({
            color: '#00000',
            // backgroundColor: '#f3f9ff',
            border: '2px solid #c9c9c9',
            borderBottom: 'none'
        });
        $('.show2').css({
            color: '#00000',
            backgroundColor: 'white',
            border: 'none',
            borderBottom: '1px solid #c9c9c9'
        });
    });
</script>

<%@ include file="/WEB-INF/common/footer.jsp" %>