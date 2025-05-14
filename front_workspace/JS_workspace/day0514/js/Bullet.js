class Bullet extends GameObject {
    constructor(container, src, x, y, width, height, velX, velY) {
        super(container, src, x, y, width, height, velX, velY);
    }

    removeObject(array, target) {
        let obj = array[array.indexOf(target)];
        this.container.removeChild(obj.img);

        array.splice(array.indexOf(target), 1);
    }

    // 물리량 변화시키기
    tick() {
        this.x += this.velX;
    }

    // 변화된 물리량 화면에 반영하기
    render() {
        enemies.forEach((e) => {
            if (collisionCheck(this.img, e.img)) {
                this.removeObject(bullets, this);
                this.removeObject(enemies, e);
                setScore(10);
            }
        });
        if (this.x > 1470) this.removeObject(bullets, this);
        this.img.style.left = this.x + "px";
    }
}
