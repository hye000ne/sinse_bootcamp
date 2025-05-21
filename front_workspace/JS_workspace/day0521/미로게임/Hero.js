class Hero extends GameObject {
    constructor(container, x, y, w, h, velX, velY, bgc, bd, bdc) {
        super(container, x, y, w, h, velX, velY, bgc, bd, bdc);

        // this.upSensor;
        this.rightSensor = new RightSensor(this.div, this, this.w - 3, 3, 3, this.h - 6, "blue", 0, "");
        // this.leftSensor;
        // this.downSensor;
    }

    tick() {
        this.x += this.velX;
        this.y += this.velY;
    }

    render() {
        //현재 화면에 등장한 벽돌과 나와의 교차여부체크
        for (let i = 0; i < brickArray.length; i++) {
            for (let j = 0; j < brickArray[i].length; j++) {
                if (brickArray[i][j] != 0 && collisionCheck(this.div, brickArray[i][j].div)) {
                    this.div.style.background = "pink";
                }
            }
        }

        this.div.style.left = this.x + "px";
        this.div.style.top = this.y + "px";
    }
}
