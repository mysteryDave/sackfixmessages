package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class DerivativeSecurityAltIDGrpComponent(noDerivativeSecurityAltIDField:Option[NoDerivativeSecurityAltIDField]=None,
                                               derivativeSecurityAltIDGroups: Option[List[DerivativeSecurityAltIDGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noDerivativeSecurityAltIDField.map(_.value).getOrElse(0) != derivativeSecurityAltIDGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoDerivativeSecurityAltIDField.TagId,noDerivativeSecurityAltIDField.map(_.value).getOrElse(0), derivativeSecurityAltIDGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noDerivativeSecurityAltIDField.foreach(fmt(b,_))
    derivativeSecurityAltIDGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object DerivativeSecurityAltIDGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    DerivativeSecurityAltIDGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoDerivativeSecurityAltIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    DerivativeSecurityAltIDGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    DerivativeSecurityAltIDGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoDerivativeSecurityAltIDField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = DerivativeSecurityAltIDGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[DerivativeSecurityAltIDGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(DerivativeSecurityAltIDGrpComponent(myFields.get(NoDerivativeSecurityAltIDField.TagId).flatMap(f=>NoDerivativeSecurityAltIDField.decode(f)),
        if (nextTagPosLookup.contains(NoDerivativeSecurityAltIDField.TagId)) DerivativeSecurityAltIDGroup.decode(flds, nextTagPosLookup(NoDerivativeSecurityAltIDField.TagId)) else None))
    } else None
  }

    
}
     