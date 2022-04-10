select u.name, sum(r.distance) as travelled_distance
from Users u
         left join Rides r on r.user_id = u.id
group by u.name
order by travelled_distance