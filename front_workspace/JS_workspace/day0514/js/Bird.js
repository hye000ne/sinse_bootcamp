class Bird {
    constructor(color, age) {
        console.log("Bird 생성자");
        this.color = color;
        this.age = age;
        console.log(this.color);
        console.log(this.age);
    }

    eat() {
        console.log("새가 먹이를 먹어요");
    }

    fly() {
        console.log("새가 날아요");
    }
}
