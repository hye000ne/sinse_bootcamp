class Bullet {
    constructor(posY, color) {
        this.div = document.createElement("div");
        this.posX = 0;
        this.posY = posY;
        this.speed = 10;
        this.color = color;

        this.div.style.width = 20 + "px";
        this.div.style.height = 20 + "px";
        this.div.style.borderRadius = 50 + "%";
        this.div.style.backgroundColor = color;
        this.div.style.position = "absolute";
        this.div.style.left = this.posX + "px";
        this.div.style.top = this.posY + "px";

        document.body.appendChild(this.div);
    }

    move() {
        this.posX += this.speed;
        this.div.style.left = this.posX + "px";
    }
}
