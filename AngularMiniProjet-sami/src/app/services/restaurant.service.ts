import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Universite } from '../models/universite';
import { Restaurant } from '../models/restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private http: HttpClient) {}

  getAllRestaurants() {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.get<Restaurant[]>(environment.url + '/restaurants', { headers });
  }

  getRestaurantById(id: number) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.get<Restaurant>(environment.url + '/restaurants/' + id, { headers });
  }

  addRestaurant(restaurant:{ nomRestaurant: string}) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post<Restaurant>(environment.url + '/restaurants', restaurant, { headers });
  }

  updateRestaurant(id: number, restaurant: Restaurant) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.put<Restaurant>(environment.url + '/restaurants/' + id, restaurant, { headers });
  }

  deleteRestaurant(id: number) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.delete(environment.url + '/restaurants/' + id, { headers });
  }

  getAllRestaurantEtatActif() {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.get(environment.url + '/Restaurants/activer', { headers });
  }

  archiverRestaurant(id: number) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.put(environment.url + '/restaurants/' + id + '/archiver', { headers });
  }

}
