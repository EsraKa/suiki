import { TestBed, inject } from '@angular/core/testing';
import { FicheMedicalService } from './fiche-medical.service';

describe('FicheMedicalService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FicheMedicalService]
    });
  });

  it('should ...', inject([FicheMedicalService], (service: FicheMedicalService) => {
    expect(service).toBeTruthy();
  }));
});
