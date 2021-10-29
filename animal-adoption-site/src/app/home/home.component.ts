import { Component, OnInit } from '@angular/core';
import { Animal } from '../models/animal.model';
import { AnimalAdoptionAPIService } from '../services/animal-adoption-api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  animalType: string;
  animalAge: number;

  animalList: Array<Animal>;

  constructor(
    private animalAdoptionAPIService: AnimalAdoptionAPIService
  ) {
    this.animalType = 'Dog';
    this.animalAge = 7;
    this.animalList = [];
  }

  ngOnInit(): void {
    this.animalAdoptionAPIService.searchAnimals().subscribe(dataResult => {
      this.animalList = dataResult;
    },
    errors => {
      console.log('Error searchAnimals');
      console.error(errors);
    });
  }

  searchAnimals(): void {
    console.log('Searching...' + this.animalAge + ' ' + this.animalType);
    this.animalAdoptionAPIService.searchAnimals(this.animalAge, this.animalType).subscribe(dataResult => {
      console.log(dataResult);
      this.animalList = dataResult;
    },
    errors => {
      console.log('Error searchAnimals');
      console.error(errors);
    });
  }

}
