class Sensor extends GameObject {
    constructor(container, hero, x, y, w, h, velX, velY, bgc, bd, bdc) {
        super(container, hero, x, y, w, h, 0, 0, bgc, bd, bdc);

        //부모 코드에 존재하지 않는 것만 처리
        this.hero = hero;
    }
}
