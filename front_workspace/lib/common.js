/*---------------------------------------------------
원하는 수를 넣으면, 해당 수까지를 최대값을 하는 
랜덤한 값을 반환하는 함수 정의
*---------------------------------------------------*/
function getRandom(max) {
    return parseInt(Math.random() * (max + 1));
}

/*---------------------------------------------------
시작값과 갯수를 넣으면, 시작값부터 해당 갯수만큼  
랜덤한 값을 반환하는 함수 정의
API 사용 예) getRandomWithStart(1, 3) => 1부터 4까지
*---------------------------------------------------*/
function getRandomWithStart(start, count) {
    return parseInt(Math.random() * count + start);
}

/*---------------------------------------------------
 한자리수 정수에 대한 0처리
*---------------------------------------------------*/
function zeroString(n) {
    //만일 n이 한자리수이면, 앞에 '0'문자를 붙여주자
    let str = n;
    if (n > 0 && n < 10) str = "0" + n;
    return str;
}

/*---------------------------------------------------
  해당월의 시작 요일 구하기 
  API 사용 예) 2025 년 5월  getStartDay(2025, 4)
*---------------------------------------------------*/
function getStartDay(yy, mm) {
    let d = new Date(yy, mm, 1); // 2025 년 5월 1일...
    return d.getDay(); //요일을 반환..
}

/*---------------------------------------------------
  영어 또는 한국어로 요일을 변환하여 반환하기 
  API 사용 예)  convertDay(2 ,"eng")
*---------------------------------------------------*/
function convertDay(n, lang) {
    let korArray = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
    let engArray = ["Sun", "Mon", "Tue", "Wed", "Tur", "Fri", "Sat"];

    let day = lang == "kor" ? korArray[n] : engArray[n];
    return day;
}

/*---------------------------------------------------
 해당 월의 마지막 날 구하기
  API 사용 예)  getLastDate(원하는연도 , 원하는 월)
*---------------------------------------------------*/
function getLastDate(yy, mm) {
    let d = new Date(yy, mm + 1, 0);
    return d.getDate();
}

/*---------------------------------------------------
 게임 충돌 체크 함수
*---------------------------------------------------*/
function collisionCheck(me, target) {
    //나에 대한 수치계산
    const me_x = parseInt(me.style.left);
    const me_y = parseInt(me.style.top);
    const me_w = parseInt(me.style.width);
    const me_h = parseInt(me.style.height);

    //목표에 대한 수치계산
    const target_x = parseInt(target.style.left);
    const target_y = parseInt(target.style.top);
    const target_w = parseInt(target.style.width);
    const target_h = parseInt(target.style.height);

    return !(me_x + me_h < target_x || me_x > target_x + target_w || me_y + me_h < target_y || me_y > target_y + target_h);
}
