/**
 * 0부터 max 사이의 정수를 무작위로 반환
 * @param {number} max - 최대값
 * @returns {number} 랜덤 정수
 */
function getRandom(max) {
    return Math.floor(Math.random() * (max + 1));
}

/**
 * min 이상 max 이하 범위의 무작위 정수를 반환
 * @param {number} min - 최소값
 * @param {number} max - 최대값
 * @returns {number} 랜덤 정수
 */
function getRandomByRange(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

/**
 * 한 자리 수에 0을 앞에 붙여 두 자리 문자열로 반환
 * @param {number} n - 숫자
 * @returns {string} 두 자리 문자열
 */
function zeroString(n) {
    return String(n).padStart(2, "0");
}

/**
 * 요일 숫자를 언어별 문자열로 변환
 * @param {number} n - 요일 숫자 (0 ~ 6)
 * @param {string} lang - 'kor' 또는 'eng'
 * @returns {string} 요일 문자열
 */
function convertDay(n, lang) {
    const korArray = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
    const engArray = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
    return lang === "kor" ? korArray[n] : engArray[n];
}

/**
 * 해당 월의 시작 요일 반환 (0: 일요일 ~ 6: 토요일)
 * @param {number} yy - 연도
 * @param {number} mm - 월 (0부터 시작)
 * @returns {number} 요일 인덱스
 */
function getStartDay(yy, mm) {
    const d = new Date(yy, mm, 1);
    return d.getDay();
}

/**
 * 해당 월의 마지막 날짜 반환
 * @param {number} yy - 연도
 * @param {number} mm - 월 (0부터 시작)
 * @returns {number} 마지막 날짜
 */
function getLastDate(yy, mm) {
    const d = new Date(yy, mm + 1, 0);
    return d.getDate();
}

/**
 * 두 요소 간 충돌 여부 판별
 * @param {HTMLElement} me - 기준 요소
 * @param {HTMLElement} target - 비교 대상 요소
 * @returns {boolean} 충돌 여부
 */
function collisionCheck(me, target) {
    const me_x = parseInt(me.style.left);
    const me_y = parseInt(me.style.top);
    const me_w = parseInt(me.style.width);
    const me_h = parseInt(me.style.height);

    const target_x = parseInt(target.style.left);
    const target_y = parseInt(target.style.top);
    const target_w = parseInt(target.style.width);
    const target_h = parseInt(target.style.height);

    return !(me_x + me_w < target_x || me_x > target_x + target_w || me_y + me_h < target_y || me_y > target_y + target_h);
}
