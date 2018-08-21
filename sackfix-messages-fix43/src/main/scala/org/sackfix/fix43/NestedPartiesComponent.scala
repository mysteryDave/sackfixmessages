package org.sackfix.fix43

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX43.xml
  */
case class NestedPartiesComponent(noNestedPartyIDsField:Option[NoNestedPartyIDsField]=None,
                                  nestedPartyIDsGroups: Option[List[NestedPartyIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noNestedPartyIDsField.map(_.value).getOrElse(0) != nestedPartyIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoNestedPartyIDsField.TagId,noNestedPartyIDsField.map(_.value).getOrElse(0), nestedPartyIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noNestedPartyIDsField.foreach(fmt(b,_))
    nestedPartyIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object NestedPartiesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NestedPartyIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoNestedPartyIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NestedPartyIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NestedPartyIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoNestedPartyIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = NestedPartyIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[NestedPartiesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(NestedPartiesComponent(myFields.get(NoNestedPartyIDsField.TagId).flatMap(f=>NoNestedPartyIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoNestedPartyIDsField.TagId)) NestedPartyIDsGroup.decode(flds, nextTagPosLookup(NoNestedPartyIDsField.TagId)) else None))
    } else None
  }

    
}
     