package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class StrmAsgnReqInstrmtGrpComponent(noRelatedSymField:Option[NoRelatedSymField]=None,
                                          relatedSymGroups: Option[List[RelatedSymGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noRelatedSymField.map(_.value).getOrElse(0) != relatedSymGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoRelatedSymField.TagId,noRelatedSymField.map(_.value).getOrElse(0), relatedSymGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noRelatedSymField.foreach(fmt(b,_))
    relatedSymGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object StrmAsgnReqInstrmtGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RelatedSymGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoRelatedSymField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RelatedSymGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RelatedSymGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoRelatedSymField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = RelatedSymGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[StrmAsgnReqInstrmtGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(StrmAsgnReqInstrmtGrpComponent(myFields.get(NoRelatedSymField.TagId).flatMap(f=>NoRelatedSymField.decode(f)),
        if (nextTagPosLookup.contains(NoRelatedSymField.TagId)) RelatedSymGroup.decode(flds, nextTagPosLookup(NoRelatedSymField.TagId)) else None))
    } else None
  }

    
}
     