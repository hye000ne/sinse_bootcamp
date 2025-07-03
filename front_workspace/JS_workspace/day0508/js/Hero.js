class Hero {
    constructor(container, posX, posY, width, height, velX, velY) {
        this.img = document.createElement("img");
        this.container = container;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.velX = velX;
        this.velY = velY;
        // 주인공의 sprite 이미지명 배열
        this.images = [];
        this.n = 0; // 이미지 배열의 인덱스
        for (let i = 1; i < 19; i++) {
            this.images.push("../../images/hero/image" + i + ".png");
        }

        this.img.src = "../../images/hero/image1.png";
        this.img.style.position = "absolute";
        this.img.style.left = this.posX + "px";
        this.img.style.top = this.posY + "px";
        this.img.style.width = this.width + "px";
        this.img.style.height = this.height + "px";

        this.container.appendChild(this.img);

        this.doIdle();
    }

    //주인공 자체 움직임
    doIdle() {
        if (this.n == 18) this.n = 0;
        this.img.src = this.images[this.n++];
        setTimeout(() => {
            this.doIdle();
        }, 100);
    }

    //모든 방향에 대한 움직임
    move() {
        this.posX += this.velX; //물리적 변화량
        this.posY += this.velY; //물리적 변화량

        //변화된 물리량을 화면에 반영(rendering)
        this.img.style.left = this.posX + "px";
        this.img.style.top = this.posY + "px";
    }
}
