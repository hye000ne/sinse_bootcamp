class Enemy extends GameObject {
    constructor(container, src, x, y, width, height, velX, velY) {
        super(container, src, x, y, width, height, velX, velY);
    }

    // 물리량 변화시키기
    tick() {
        this.x += this.velX;
        this.y += this.velY;
    }

    // 변화된 물리량 화면에 반영하기
    render() {
        this.img.style.left = this.x + "px";
        this.img.style.top = this.y + "px";
    }
}
