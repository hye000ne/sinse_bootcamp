// 게임에 등장하는 모든 객체의 최상위 객체를 정의 => 재사용성
class GameObject {
    constructor(container, src, x, y, width, height, velX, velY) {
        this.container = container;
        this.img = document.createElement("img");
        this.src = src;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velX = velX;
        this.velY = velY;

        this.img.src = this.src;
        this.img.style.position = "absolute";
        this.img.style.left = this.x + "px";
        this.img.style.top = this.y + "px";
        this.img.style.width = this.width + "px";
        this.img.style.height = this.height + "px";

        this.container.appendChild(this.img);
    }

    // 물리량 변화시키기
    tick() {}

    // 변화된 물리량 화면에 반영하기
    render() {}
}
