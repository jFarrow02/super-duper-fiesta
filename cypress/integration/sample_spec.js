
describe('my first test', () => {
    it('visits the restaurantfinder app', () => {
        cy.visit('http://localhost:3000');
        cy.contains('Hello World');
    });
});