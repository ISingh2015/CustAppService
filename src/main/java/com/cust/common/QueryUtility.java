package com.cust.common;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;


public class QueryUtility {
	/**
	 * @param queryCriteria
	 * @param sessionFactory
	 * @param obj
	 * @return
	 * @throws ApplicationException
	 *             This method is used to create the Query where and order by
	 *             clause, base on the QueryCriteria object. The QueryCriteria
	 *             object has the sortFilter and the queryFilter objects which
	 *             contain a list of property names that will be used in the
	 *             building the where clause and the order by clause.
	 *             getTableFieldName method is used to fetch the corresponding
	 *             column name for the given property name from the class
	 *             metatdata.
	 */
	public static String getQueryCriteriaString(QueryCriteria queryCriteria,
			SessionFactory sessionFactory, Object obj)
			throws ApplicationException {
		if (queryCriteria == null)
			return "";
		String finalCriteria = "", finalFilter = "", finalSort = "";

		List<FilterCriteria> filterCriteriaList = queryCriteria
				.getFilterCriteria();
		List<SortCriteria> sortCriteriaList = queryCriteria.getSortCriteria();

		if (filterCriteriaList != null) {
			for (FilterCriteria filterCriteria : filterCriteriaList) {
				finalFilter += " and "
						+ getTableFieldName(
								filterCriteria.getFilterFieldName(),
								sessionFactory, obj) + " "
						+ filterCriteria.getFilterCondition() + " " + "'"
						+ filterCriteria.getFilterFieldValue() + "'";
			}
		}
		if (sortCriteriaList != null) {
			if (sortCriteriaList.size() == 1) {
				finalSort = " Order By "
						+ getTableFieldName(sortCriteriaList.get(0)
								.getSortFieldName(), sessionFactory, obj)
						+ " "
						+ ((sortCriteriaList.get(0).getSortDirection() == null) ? ""
								: sortCriteriaList.get(0).getSortDirection());
			} else if (sortCriteriaList.size() > 1) {
				finalSort = " Order By "
						+ getTableFieldName(sortCriteriaList.get(0)
								.getSortFieldName(), sessionFactory, obj);
				for (int cnt = 1; cnt <= sortCriteriaList.size(); cnt++) {
					finalSort = ", "
							+ getTableFieldName(sortCriteriaList.get(cnt)
									.getSortFieldName(), sessionFactory, obj);
				}
				finalSort += " "
						+ ((sortCriteriaList.get(0).getSortDirection() == null) ? ""
								: sortCriteriaList.get(0).getSortDirection());
			}
		}
		if (finalFilter.indexOf("\'\\") > 0) {
			finalFilter = finalFilter.replace("\'\\", "").replace("\\\'","");
		}
		finalCriteria = finalFilter + finalSort;
		return finalCriteria;
	}

	private static String getTableFieldName(String propertyName,
			SessionFactory sessionFactory, Object obj)
			throws ApplicationException {
		String[] columnNames = null;
		ClassMetadata hibernateMetadata = sessionFactory.getClassMetadata(obj
				.getClass());
		if (hibernateMetadata instanceof AbstractEntityPersister) {
			AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;
			columnNames = persister.getPropertyColumnNames(propertyName);
		}
		return columnNames[0];
	}
}
