/*--------------------------
 랜덤 값 구하기 (정수형)
 *--------------------------*/
function getRandom(max) {
    return parseInt(Math.random() * max);
}

/*--------------------------
 한자리 수에 대한 0 처리
 *--------------------------*/
function zeroString(n) {
    //n이 한자리 수 이면 '0' 추가
    let str = n;
    if (0 <= n && n < 10) str = "0" + n;
    return str;
}

/*--------------------------
 해당 월의 시작 요일 구하기
 API 사용 예 )
 *--------------------------*/
function getStartDay(yy, mm) {
    let d = new Date(yy, mm, 1);
    return d.getDay();
}

/*--------------------------
 해당 월의 마지막 날 구하기
 API 사용 예 ) getLastDate(원하는 연도,원하는 월)
 *--------------------------*/
function getLastDate(yy, mm) {
    let d = new Date(yy, mm, 0);

    return d.getDate();
}

/*--------------------------
영어 또는 한국어로 요일을 변환하여 반환하기
API 사용 예 ) 
*--------------------------*/
function convertDay(n, lang) {
    let kor_days = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
    let eng_days = ["Sun", "Mon", "Tue", "Wed", "Tur", "Fri", "Sat"];

    //언어 미입력 시 한국(default)
    if (lang == undefined || lang == null) lang = "kor";

    if (lang === "kor") return kor_days[n];
    if (lang === "eng") return eng_days[n];
}
