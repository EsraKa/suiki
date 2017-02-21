import { TestBed, inject } from '@angular/core/testing';
import { SymptomeService } from './symptome.service';

describe('SymptomeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SymptomeService]
    });
  });

  it('should ...', inject([SymptomeService], (service: SymptomeService) => {
    expect(service).toBeTruthy();
  }));
});
