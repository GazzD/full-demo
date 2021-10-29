import { TestBed } from '@angular/core/testing';

import { AnimalAdoptionAPIService } from './animal-adoption-api.service';

describe('AnimalAdoptionAPIService', () => {
  let service: AnimalAdoptionAPIService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AnimalAdoptionAPIService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
