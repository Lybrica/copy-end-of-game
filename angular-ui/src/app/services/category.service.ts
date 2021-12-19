import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {categoriesApi} from "../models/links";
import {Category} from "../models/category";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient: HttpClient) { }

  readCategoriesFromServer(): Observable<Array<Category>> {
    return this.httpClient.get<Array<Category>>(categoriesApi);
  }
}
