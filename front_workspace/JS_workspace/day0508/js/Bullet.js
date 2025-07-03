class Bullet {
    constructor(container, posX, posY, width, height, velX, velY) {
        this.div = document.createElement("div");
        this.container = container;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.velX = velX;
        this.velY = velY;

        this.div.style.backgroundColor = "red";
        this.div.style.position = "absolute";
        this.div.style.left = posX + "px";
        this.div.style.top = posY + "px";
        this.div.style.width = width + "px";
        this.div.style.height = height + "px";
        this.div.style.borderRadius = 50 + "%";
        this.div.style.filter = "blur(2px)";

        this.container.appendChild(this.div);
    }

    move() {
        //만일 총알이 적군등에 맞지 않고 화면 밖으로 나가는 경우, 메모리 효율성을 위해서
        //제거 (화면제거, 배열제거)
        if (this.posX >= 1500) {
            this.container.removeChild(this.div); //화면제거
            bulletArray.splice(bulletArray.indexOf(this), 1); //배열 원소 제거
        }
        this.posX += this.velX;
        this.div.style.left = this.posX + "px";
    }
}
