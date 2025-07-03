class Duck extends Bird {
    // 의무!! 자식 클래스에서 생성자를 정의할 때 무조건 부모의 생성자 호출을 해야함
    constructor(color, age) {
        super(color, age); // super()가 부모의 생성자(constructor)를 의미
        console.log(this.color);
        console.log(this.age);
    }

    fly() {
        console.log("오리가 날아요");
    }
}
