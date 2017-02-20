import { TestBed, inject } from '@angular/core/testing';
import { PathologieService } from './pathologie.service';

describe('PathologieService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PathologieService]
    });
  });

  it('should ...', inject([PathologieService], (service: PathologieService) => {
    expect(service).toBeTruthy();
  }));
});
