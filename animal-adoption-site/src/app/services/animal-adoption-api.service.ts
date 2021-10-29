import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Animal } from '../models/animal.model';

@Injectable({
  providedIn: 'root'
})
export class AnimalAdoptionAPIService {

  private readonly baseUrl: string = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  searchAnimals(age?: number, type?:string): Observable<Animal[]> {
    console.log(`What I get on the service ${age} ${type}`)

    let httpParams = new HttpParams();
    if (age) httpParams = httpParams.append('age', age);
    if (type) httpParams = httpParams.append('type', type);

    console.log(httpParams.toString());

    const httpOptions = {
      params: httpParams
    };

    console.log(httpOptions);
    return this.http.get<Animal[]>(this.baseUrl + '/animals', httpOptions);
  }

}
