import { ObsResp } from './response.utils';

export interface CrudOperations <E, Dto> {
    create(createDto: Dto): ObsResp<E>;
    findAll(): ObsResp<E[]>;
    findById(id: number | string): ObsResp<E>;
    updateById(id: number | string, updateDto: Dto): ObsResp<E>;
    deleteById(id: number | string): ObsResp<string>;
  }
