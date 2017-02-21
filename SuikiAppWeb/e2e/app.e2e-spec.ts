import { SuikiAppWebPage } from './app.po';

describe('suiki-app-web App', () => {
  let page: SuikiAppWebPage;

  beforeEach(() => {
    page = new SuikiAppWebPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
