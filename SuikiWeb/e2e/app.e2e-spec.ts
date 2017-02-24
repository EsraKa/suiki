import { SuikiWebPage } from './app.po';

describe('suiki-web App', () => {
  let page: SuikiWebPage;

  beforeEach(() => {
    page = new SuikiWebPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
